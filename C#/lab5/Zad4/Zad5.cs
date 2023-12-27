using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zad4
{
    internal class Zad5
    {
        public static void main(string[] args)
        {
            MojTypDanych pewnaksiazka = new MojTypDanych("ksiazka",30);
            OsobaZad5 osoba1 = new OsobaZad5("Izabela", "Łęcka", 23,pewnaksiazka);
            try
            {
               OsobaZad5 osoba2 = OsobaZad5.KopiujObiekt(null);
                Console.WriteLine(osoba2.ToString());
            }
            catch(ArgumentNullException e) 
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
