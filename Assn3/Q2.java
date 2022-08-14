import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.Formatter;
import java.util.ArrayList;
import java.util.List;

public class Q2
{
  public static void main(String[] args)
  {
    List<Movie> movies = getMovies("moviebudgets3.txt");
    saveMovieProfits(movies, "movieprofit.txt");
  }

  /*
  Opens file of name filename - file path starts from app's root directory.
  Assumes each line is one record with a title, income, and expense (respectively) separated by tabs.
  Returns list of all records as Movie objects.
  */
  private static List<Movie> getMovies(String filename)
  {
    List<Movie> movies = new ArrayList<Movie>();
    try (Scanner input = new Scanner(Paths.get(filename)))
    {
      while (input.hasNextLine())
      {
        String line = input.nextLine();
        String[] parsedLine = line.split("\t");
        String title = parsedLine[0];
        Double income = Double.valueOf(parsedLine[1]);
        Double expense = Double.valueOf(parsedLine[2]);
        movies.add(new Movie(title, income, expense));
      }
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
    }
    return movies;
  }

  /*
  Writes file of name filename - file path starts from app's root directory.
  Will save each movie with a title and it's profit (respectively) separated by tabs.
  */
  private static void saveMovieProfits(List<Movie> movies, String filename)
  {
    try (Formatter output = new Formatter(filename))
    {
      for (Movie movie : movies)
      {
        output.format("%s%n", movie.profitToRecord());
      }
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
    }
  }
}