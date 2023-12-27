using Zad4;

Osoba osoba1 = new Osoba("Izabela", "Łęcka", 23);
try
{
    Osoba osoba2 = Osoba.KopiujObiekt(null);
    Console.WriteLine(osoba2.ToString());
}
catch (ArgumentNullException e)
{
    Console.WriteLine("Złapano wyjątek: "+e.Message);
}

