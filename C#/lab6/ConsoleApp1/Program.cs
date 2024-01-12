using CsvHelper;
using System.Globalization;
using ConsoleApp1;


string filePath = "sample.csv";

try
{
    while (true)
    {
        Console.WriteLine("Wybierz opcję z menu głównego:\n1.Wyświetl dane\n2.Dodaj osobę\n3.Modyfikuj osobę\n4.Usuń osobę\n5.Wyjście z programu");
        int wybor = Convert.ToInt32(Console.ReadLine());
        switch (wybor)
        {
            case 1: ReadAndDisplayDataFromCsv(filePath); break;
            case 2: WriteDataToCsv(filePath); break;
            case 3: ModifyPersonInCsv(filePath); break;
            case 4: DeleteDataFromCsv(filePath); break;
            case 5: return;
            default: Console.WriteLine("Nieprawidłowy wybór opcji"); break;
        }
    }
}
catch (ArgumentException e)
{
    Console.WriteLine(e.Message+"\nWprowadź dane jeszcze raz");
    WriteDataToCsv(filePath); //ponowne wywołanie metody w przypadku wystąpienia wyjątku błędnego inputu
}


static void DeleteDataFromCsv(string filePath)
{
    Person osobaDoUsuniecia = null;

    Console.WriteLine("Podaj pesel osoby, którą chcesz usunąć");
    string podanyPesel = Console.ReadLine();

    var records = new List<Person>();

    using (var reader = new StreamReader(filePath))
    using (var csv = new CsvReader(reader, CultureInfo.InvariantCulture))
    {
        records = csv.GetRecords<Person>().ToList();
    }
    foreach (var record in records)
    {
        if (record.PersonalIDNumber == podanyPesel)
        {
            osobaDoUsuniecia = record;
        }
    }
    if(osobaDoUsuniecia != null)
    {
        records.Remove(osobaDoUsuniecia);
        using (var writer = new StreamWriter(filePath, false))
        using (var csv = new CsvWriter(writer, CultureInfo.InvariantCulture))
        {
            csv.WriteRecords(records);
        }
        Console.WriteLine("\nUsunięto osobę o wybranym numerze pesel!\n");
    }
    else
    {
        Console.WriteLine("\nNie znaleziono użytkownika o podanym numeru pesel!\n");
    }
}

static void ModifyPersonInCsv(string filePath)
{
    Console.WriteLine("Podaj pesel osoby, którą chcesz zmodyfikować");
    string podanyPesel = Console.ReadLine();

    var records = new List<Person>();

    using (var reader = new StreamReader(filePath))
    using (var csv = new CsvReader(reader, CultureInfo.InvariantCulture))
    {
        records = csv.GetRecords<Person>().ToList();
    }
        foreach (var record in records)
        {
            if(record.PersonalIDNumber == podanyPesel)
            {
                Console.WriteLine("Nadpisz dane wybranej osoby");
                Console.WriteLine("Podaj imię");
                string imie = Console.ReadLine();
                Console.WriteLine("Podaj nazwisko");
                string nazwisko = Console.ReadLine();
                Console.WriteLine("Miasto:");
                string miasto = Console.ReadLine();
                Console.WriteLine("Ulica:");
                string ulica = Console.ReadLine();
                Console.WriteLine("Numer mieszkania:");
                string mieszkanie = Console.ReadLine();
                Console.WriteLine("Podaj PESEL");
                string pesel = Console.ReadLine();
                Console.WriteLine("Podaj adres email");
                string email = Console.ReadLine();

                if (imie == null || nazwisko == null || miasto == null || ulica == null || mieszkanie == null || pesel == null || email == null)
                    throw new ArgumentException("Któraś z wprowadzonych wartości jest wartością NULL!");
                else if (pesel.Length != 11)
                    throw new ArgumentException("Długość numeru pesel jest inna niż 11!");
                else if (!email.Contains("@"))
                    throw new ArgumentException("Niepoprawna składnia adresu email!");
                else
                {
                    record.Name = imie;
                    record.Surname = nazwisko;
                    record.Address = new Address(miasto, ulica, mieszkanie);
                    record.PersonalIDNumber = pesel;
                    record.Email = email;

                    using (var writer = new StreamWriter(filePath, false))
                    using (var csv = new CsvWriter(writer, CultureInfo.InvariantCulture))
                    {
                        csv.WriteRecords(records);
                    }

                    Console.WriteLine("\nZaktualizowano dane osoby w pliku CSV!\n");
                }
            }
            else
            {
            Console.WriteLine("\nNie znaleziono użytkownika o podanym numeru pesel!\n");
            }
        }
}

//zapis do pliku csv
static void WriteDataToCsv(string filePath)
{
    Console.WriteLine("Podaj imię");
    string imie = Console.ReadLine();
    Console.WriteLine("Podaj nazwisko");
    string nazwisko = Console.ReadLine();
    Console.WriteLine("Miasto:");
    string miasto = Console.ReadLine();
    Console.WriteLine("Ulica:");
    string ulica = Console.ReadLine();
    Console.WriteLine("Numer mieszkania:");
    string mieszkanie = Console.ReadLine();
    Console.WriteLine("Podaj PESEL");
    string pesel = Console.ReadLine();
    Console.WriteLine("Podaj adres email");
    string email = Console.ReadLine();

    if (imie == null || nazwisko == null || miasto == null || ulica == null || mieszkanie == null || pesel == null || email == null)
        throw new ArgumentException("Któraś z wprowadzonych wartości jest wartością NULL!");
    else if (pesel.Length != 11)
        throw new ArgumentException("Długość numeru pesel jest inna niż 11!");
    else if (!email.Contains("@"))
        throw new ArgumentException("Niepoprawna składnia adresu email!");
    else
    {
        Address adresOsoby = new Address(miasto, ulica, mieszkanie);

        var nowaOsoba = new Person
        {
            Name = imie,
            Surname = nazwisko,
            Address = adresOsoby,
            PersonalIDNumber = pesel,
            Email = email
        };

        using (var writer = new StreamWriter(filePath, true))
        using (var csv = new CsvWriter(writer, CultureInfo.InvariantCulture))
        {
            csv.WriteRecord(nowaOsoba);
        }
        Console.WriteLine("Dodano nową osobę do pliku CSV!");
    }
}

//odczyt z pliku csv
static void ReadAndDisplayDataFromCsv(string filePath)
{
    using (var reader = new StreamReader(filePath))
    using (var csv = new CsvReader(reader, CultureInfo.InvariantCulture))
    {
        var records = csv.GetRecords<Person>().ToList();
        
        Console.WriteLine("\nDane odczytane z pliku CSV:");
        foreach (var record in records)
        {
            Console.WriteLine($"Imię: {record.Name},\nNazwisko: {record.Surname},\nAdres:" +
                $"{record.Address},\nPESEL: {record.PersonalIDNumber},\nEmail: {record.Email}\n");
        }
    }
}