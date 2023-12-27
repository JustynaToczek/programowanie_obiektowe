
static void MojaMetoda(string napis)
{
    try
    {
        Console.Write(napis.Length);
    }
    catch (Exception e)
    {
        // Dodanie obsługiwanego wyjątku jako przyczyny do nowego wyjątku
        throw new Exception("Wystąpił nowy wyjątek", e);
    }

}

try
{
    MojaMetoda(null);
}
catch (Exception e)
{
    Console.WriteLine($"Zgłoszono wyjątek: {e.GetType().FullName}"); //przy wprowadzeniu null jako argumentu zgloszony zostaje wyjątek: System.NullReferenceException
    Console.WriteLine($"Wiadomość: {e.Message}");
    Console.WriteLine($"Ślad stosu: {e.StackTrace}");

    throw; //ponowne zgłaszanie występującego wyjątku poprzez thorw bez argumentu
}