public
class SomeClass
{
    public void CanThrowException(int index) {
            if (new Random().Next(5) == 0)
            throw new Exception("Wyjątek wystąpił w instrukcji numer:"+(index+1));
    }

}
class Program
{
    static void Main(string[] args)
    {
        SomeClass someClassObj = new SomeClass();
        try {
            for (int i = 0; i < 5; i++)
            {
                someClassObj.CanThrowException(i);
            }
        }
        catch (Exception e)
        {
            Console.WriteLine(e.Message);
        }
    }
}