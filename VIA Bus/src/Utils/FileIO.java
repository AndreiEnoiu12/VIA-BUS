package Utils;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * A class responsible for reading and writing binary files.
 */

public class FileIO {


    /**
    * Writes the given object to a file with the given file name.
    * @param fileName the name and path of the file to write to
    * @param obj the object to write to the file
    * @throws FileNotFoundException if the file with fileName is not found
    * @throws IOException if there is an error writing to the file
    */

	public void writeToFile(String fileName, Object obj)
			throws FileNotFoundException, IOException {
		ObjectOutputStream out = null;

		try {
			FileOutputStream fileOutStream = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fileOutStream);

			out.writeObject(obj);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					System.out.println("IO Error closing file " + fileName);
				}
			}
		}
	}

   /**
    * Writes the objects in the given array to a file with the given file name.
    * @param fileName the name and path of the file to write to
    * @param objs the Object array to write to the file
    * @throws FileNotFoundException if the file with fileName is not found
    * @throws IOException if there is an error writing to the file
    */

	public void writeToFile(String fileName, Object[] objs)
			throws FileNotFoundException, IOException {
		ObjectOutputStream out = null;

		try {
			FileOutputStream fileOutStream = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fileOutStream);

			for (int i = 0; i < objs.length; i++) {
				out.writeObject(objs[i]);
			}
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					System.out.println("IO Error closing file " + fileName);
				}
			}
		}
	}

   /**
    * Reads the first object from the file with the given file name and returns it.
    * Whoever calls the method will need to cast it from type Object to its real type
    * @param fileName the name and path of the file that is read
    * @return the Object read from the file
    * @throws FileNotFoundException if the file with fileName is not found
    * @throws IOException if there is an error reading the file
    * @throws ClassNotFoundException if the class of the serialized object cannot be found
    */

	public Object readObjectFromFile(String fileName)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		Object obj = null;
		ObjectInputStream in = null;

		try {
			FileInputStream fileInStream = new FileInputStream(fileName);
			in = new ObjectInputStream(fileInStream);
			try {
				obj = in.readObject();
			} catch (EOFException eof) {
				// Done reading
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("IO Error closing file " + fileName);
				}
			}
		}

		return obj;
	}

   /**
    * Reads all objects from the file with the given file name and returns it as an Object array.
    * Whoever calls the method will need to cast the Objects to their real type.
    * @param fileName the name and path of the file that is read
    * @return and Object array with all the objects read from the file
    * @throws FileNotFoundException if the file with fileName is not found
    * @throws IOException if there is an error reading the file
    * @throws ClassNotFoundException if the class of the serialized object cannot be found
    */

	public Object[] readArrayFromFile(String fileName)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Object> objs = new ArrayList<Object>();
		ObjectInputStream in = null;

		try {
			FileInputStream fileInStream = new FileInputStream(fileName);
			in = new ObjectInputStream(fileInStream);
			while (true) {
				try {
					objs.add(in.readObject());
				} catch (EOFException eof) {
					// Done reading
					break;
				}
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("IO Error closing file " + fileName);
				}
			}
		}

		return objs.toArray();
	}
}
