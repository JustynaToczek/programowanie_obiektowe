using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zad4
{
    internal class Osoba
    {
        public string Imie {  get; set; }
        public string Nazwisko { get; set; }
        public int Wiek {  get; set; }

        public Osoba(string imie, string nazwisko, int wiek)
        {
            Imie = imie;
            Nazwisko = nazwisko;
            Wiek = wiek;
        }

        public override string ToString()
        {
            return "Imię: " + Imie + ", nazwisko: " + Nazwisko + ", wiek:" + Wiek;
        }

        public static Osoba KopiujObiekt(Osoba osoba)
        {
            if (osoba == null)
            {
                throw new ArgumentNullException();
            }
            return (Osoba)osoba.MemberwiseClone();
        }
    }
}
