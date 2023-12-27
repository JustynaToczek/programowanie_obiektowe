using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zad4
{
    internal class OsobaZad5
    {
        public string Imie { get; set; }
        public string Nazwisko { get; set; }
        public int Wiek { get; set; }
        public MojTypDanych MojTypDanych { get; set; }

        public OsobaZad5(string imie, string nazwisko, int wiek, MojTypDanych mojtypdanych)
        {
            Imie = imie;
            Nazwisko = nazwisko;
            Wiek = wiek;
            MojTypDanych = mojtypdanych;
        }

        public override string ToString()
        {
            return "Imię: " + Imie + ", nazwisko: " + Nazwisko + ", wiek:" + Wiek+", mojtypdanych: przedmiot: "+MojTypDanych.Przedmiot+", cena: "+MojTypDanych.Cena;
        }

        public static OsobaZad5 KopiujObiekt(OsobaZad5 osoba)
        {
            if (osoba == null)
            {
                throw new ArgumentNullException();
            }
            return (OsobaZad5)osoba.MemberwiseClone();
        }
    }
}
