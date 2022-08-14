import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest
{
  /* MY, RECURSIVE BINARY SEARCH */
  public static int binarySearchRecursive(int[] data, int key, int high, int low)
  {
    
    int mid = (low + high + 1) / 2;

    System.out.print(remainingElements(data, low, high));

    for (int i = 0; i < mid; i++)
    {
      System.out.print("   ");
    }
    System.out.println(" * ");
    
    if (key == data[mid]) return mid;
    if (low >= high) return -1;
    if (key < data[mid]) return binarySearchRecursive(data, key, mid - 1, low); // current mid is new high
    return binarySearchRecursive(data, key, high, mid + 1); // current mid is new low
  }

  /*
  takes an array of integers, returns the index of key in the array.
  if key is not found return is -1
  */
  public static int binarySearchRecursive(int[] data, int key)
  {
    int low = 0;
    int high = data.length - 1;

    System.out.println("recursive: ");

    return binarySearchRecursive(data, key, high, low);
  }
  
  /* ORIGINAL, ITERATIVE BINARY SEARCH */
  public static int binarySearch(int[] data, int key)
  {
    int low = 0;
    int high = data.length - 1;
    int mid = (low + high + 1) / 2;
    int pos = -1;

    System.out.println("iterative: ");
    do
    {
      System.out.print(remainingElements(data, low, high));

      for (int i = 0; i < mid; i++)
      {
        System.out.print("   ");
      }
      System.out.println(" * ");

      if (key == data[mid])
      {
        pos = mid;
      }
      else if (key < data[mid])
      {
        high = mid - 1;
      }
      else
      {
        low = mid + 1;
      }

      mid = (low + high + 1) / 2;
    } while ((low <= high) && (pos == -1));

    return pos;
  }

  private static String remainingElements(int[] data, int low, int high)
  {
    StringBuilder temp = new StringBuilder();

    for (int i = 0; i < low; i++)
    {
      temp.append("   ");
    }

    for (int i = low; i <= high; i++)
    {
      temp.append(data[i] + " ");
    }

    return String.format("%s%n", temp);
  }

  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    SecureRandom generator = new SecureRandom();

    int[] data = generator.ints(15, 10, 91).sorted().toArray();
    System.out.printf("%s%n%n", Arrays.toString(data));

    System.out.print("Please enter an int value (-1 to exit): ");
    int searchInt = input.nextInt();

    while (searchInt != -1)
    {
      int pos = binarySearch(data, searchInt);
      int pos_recursive = binarySearchRecursive(data, searchInt);

      if (pos == -1)
      {
        System.out.printf("%d was not found (iteratively)%n%n", searchInt);
      }
      else
      {
        System.out.printf("%d was found in position %d (iteratively)%n%n", searchInt, pos);
      }

      if (pos_recursive == -1)
      {
        System.out.printf("%d was not found (recursively)%n%n", searchInt);
      }
      else
      {
        System.out.printf("%d was found in position %d (recursively)%n%n", searchInt, pos_recursive);
      }

      System.out.print("Please enter an int value (-1 to exit): ");
      searchInt = input.nextInt();
    }
  }
}