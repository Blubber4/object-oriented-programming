import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Q2
{
  public static void main(String[] args)
  {
    Integer[] arr = getRandomIntArray(20, 100);
    List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));

    Collections.sort(list);
    removeElements(list, 7, 14);
    printHoroscope(list);
  }

  /*
  Takes the size of the array, and the upper bound for numbers in the array.
  Generates random numbers between 1 and the upper bound to fill the array (inclusive of 1 and upper bound)
  */
  private static Integer[] getRandomIntArray(int size, int upper)
  {
    Integer[] arr = new Integer[size];
    Random rand = new Random();

    for (int i = 0; i < size; i++)
    {
      arr[i] = rand.nextInt(upper - 1) + 1;
    }
    return arr;
  }

  /*
  Takes a list of Integers, a lower bound, and an upper bound.
  Removes all elements from the collection between lower and upper bound (inclusive of both bounds - bound is index).
  */
  private static void removeElements(List<Integer> list, int lower, int upper)
  {
    list.subList(lower, upper + 1).clear();
  }

  private static void printHoroscope(List<Integer> list)
  {
    for (int i = 0; i < list.size(); i++)
    {
      Integer element = list.get(i);
      String prediction;

      if (element >= 70)
      {
        prediction = "good luck";
      }
      else if (element <= 40)
      {
        prediction = "bad luck";
      }
      else
      {
        prediction = "super";
      }

      System.out.println("If your birth month is " + (i+1) + ", your prediction is: " + prediction);
    }
  }
}