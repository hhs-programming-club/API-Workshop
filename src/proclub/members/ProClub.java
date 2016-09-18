package proclub.members;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import javax.imageio.ImageIO;

public class ProClub{
	public static class Beginner extends Novice{
		public static String tab(){ return "\t"; }
		public static String string(Object... objs){
			return string(",", objs);
		}		
		public static String string(String separator, Object... objs){
			StringBuilder sb = new StringBuilder();
			for(Object o : objs) sb.append(o + separator);
			return sb.toString();
		}
	}
	public static class Novice extends Intermediate{
		private static HashMap<String, Object> map = new HashMap<String, Object>();

		public static void println(Object... str){ System.out.println(Arrays.deepToString(str)); }
		public static void println(String... str){ System.out.println(Arrays.deepToString(str)); }
		public static void println(int... str){ System.out.println(Arrays.toString(str)); }

		public static void println(Object str){ System.out.println(str); }
		public static void println(int str){ System.out.println(str); }
		public static void println(double str){ System.out.println(str); }
		public static void println(long str){ System.out.println(str); }
		public static void println(boolean str){ System.out.println(str); }
		public static void println(){ System.out.println(); }

		public static void print(Object... str){ System.out.print(Arrays.deepToString(str)); }
		public static void print(String... str){ System.out.print(Arrays.deepToString(str)); }
		public static void print(int... str){ System.out.print(Arrays.toString(str)); }

		public static void print(Object str){ System.out.print(str); }
		public static void print(int str){ System.out.print(str); }
		public static void print(double str){ System.out.print(str); }
		public static void print(long str){ System.out.print(str); }
		public static void print(boolean str){ System.out.print(str); }

		public static void map(String str, Object obj){
			map.put(str, obj);
		}
		public static Object map(String str){
			return map.get(str);
		}
		public static String[] unique(String... arr){
			Set<String> set = new HashSet<String>();
			for(String s : arr) set.add(s);
			return set.toArray(new String[set.size()]);
		}

		private static Scanner s = new Scanner(System.in);
		public static String scan(){
			String str = s.next();
			return str;
		}
		public static String scanLine(){
			String str = s.nextLine();
			return str;
		}
		public static int scanInt(){
			int str = s.nextInt();
			return str;
		}
		public static String[] copy(String... arr){ return Arrays.copyOf(arr, arr.length); }
		public static int[] copy(int... arr){ return Arrays.copyOf(arr, arr.length); }
		public static List copy(List arr){ List l = new ArrayList(); Collections.copy(arr, l); return l; }


	}
	public static class Intermediate extends Pro{
		public static void sort(List arr){
			Collections.sort(arr);
		}
		public static void sort(int... arr){
			Arrays.sort(arr);
		}
		public static void sort(Object... arr){
			Arrays.sort(arr);
		}
		
		public static String read(File file){
			if(!file.exists()){
				warn("File does not exist! ");
				return null;
			}
			try { return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
			} catch (IOException e) { warn("There was an error reading the file!"); }
			return null;
		}
		public static String read(String file){
			return read(new File(file));
		}
		public static void write(File file, String out){
			if(!file.exists()){
				warn("File does not exist!");
				return;
			}
			try {
				Files.write(Paths.get(file.getAbsolutePath()), out.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
				warn("Unable to write file!");
			}
		}
		public static void write(String file, String out){
			write(new File(file), out);
		}
		public static boolean makeFile(File f){
			if(f.exists()) return false;
			try { f.createNewFile();
			} catch (IOException e) {e.printStackTrace();}
			return true;
		}
		public static boolean makeFile(String str){
			return makeFile(new File(str));
		}
		public static boolean makeFolder(File f){
			if(f.exists()) return false;
			f.mkdirs();
			return true;
		}
		public static boolean makeFolder(String str){
			return makeFolder(new File(str));
		}

		public static int toInt(String str){
			try{
				return Integer.valueOf(str);
			} catch(Exception e){ warn("Yikes! Are you sure that was a number? An error was caught: " + e.getMessage()); }
			return 0;
		}
		public static int toInt(double str){
			return (int) str;
		}
		public static double toDecimal(String str){
			return Double.valueOf(str);
		}

		public static ArrayList array(Object... objs){
			ArrayList arr = new ArrayList();
			for(Object o : objs) arr.add(o);
			return arr;
		}

		public static int getHour(){
			Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
			calendar.setTime(new Date());
			return calendar.get(Calendar.HOUR);
		}
		public static int getHourOfDay(){
			Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
			calendar.setTime(new Date());
			return calendar.get(Calendar.HOUR_OF_DAY);
		}
		public static int getMinute(){
			Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
			calendar.setTime(new Date());
			return calendar.get(Calendar.MINUTE);
		}
		public static int getSecond(){
			Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
			calendar.setTime(new Date());
			return calendar.get(Calendar.SECOND);
		}
		public static int getDate(){
			Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
			calendar.setTime(new Date());
			return calendar.get(Calendar.DAY_OF_MONTH);
		}
		public static String getDayOfWeek(){
			Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
			calendar.setTime(new Date());
			int d = calendar.get(Calendar.DAY_OF_WEEK);
			String[] arr = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
			return arr[d];
		}
		public void takeScreenshot(String fileName) throws Exception {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(screenRectangle);
			ImageIO.write(image, "png", new File(fileName));
		}
	}
	public static class Pro extends ProClub{
		public static double challenge1(int x){ return x + 2; }
		public static double challenge2(int x){ return (3 * challenge1(x)); }
		public static double challenge3(int x){ return challenge2(x) % 10; }
		public static double challenge4(int x){ return challenge3(x) * challenge3(x) + 1; }
	}

	private static void warn(String warning){
		System.err.println(warning);
	}
}
