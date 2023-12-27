using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie3
{
    internal class Osoba : IOsoba
    {
        public string Imie { get; set; }
        public string Nazwisko { get; set; }

        public Osoba(string imie, string nazwisko)
        {
            Imie = imie;
            Nazwisko = nazwisko;
        }

        public string ZwrocPelnaNazwe()
        { 
            return Imie +"\n" + Nazwisko;
        }
    }
}
