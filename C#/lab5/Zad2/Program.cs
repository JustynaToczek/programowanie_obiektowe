
using Zad2;

try
{
    losujJedenWyjatek();
}
catch (WyjatekNullPointerException e)
{
    Console.WriteLine("Złapano wyjątek: " + e.Message);
}
catch(WyjatekDivideByZero e)
{
    Console.WriteLine("Złapano wyjątek: " + e.Message);
}
catch(WyjatekClassNotFound e)
{
    Console.WriteLine("Złapano wyjątek: " + e.Message);
}



static void losujJedenWyjatek()
{
    Random random = new Random();
    int wylosowanaLiczba = random.Next(3);
    switch(wylosowanaLiczba)
    {
        case 0: throw new WyjatekNullPointerException();
            break;
        case 1: throw new WyjatekDivideByZero();
            break; 
        case 2: throw new WyjatekClassNotFound();
            break;
    }
}


