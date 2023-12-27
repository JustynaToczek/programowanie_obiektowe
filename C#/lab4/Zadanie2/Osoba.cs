using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie2
{
    internal class Osoba
    {
        public string Imie { get; set; }
        public string Nazwisko { get; set; }
        public string Pesel { get; set; }

        public Osoba(string imie, string nazwisko, string pesel)
        {
            Imie = imie;
            Nazwisko = nazwisko;
            Pesel = pesel;
        }

        public void SetFirstName(string firstname)
        {
            Imie = firstname;
        }

        public void SetLastName(string lastname)
        {
            Nazwisko = lastname;
        }
        public void SetPesel(string pesel)
        {
            Pesel = pesel;
        }

        public int GetAge()
        {
            int wiek;
            DateTime aktualnaData = DateTime.Now;
            int rok = aktualnaData.Year;
            int cyfryZPesela = Convert.ToInt32(Pesel.Substring(0, 2));

            if (cyfryZPesela > 30) //urodzony po 1930, ale przed 2000
            {
                wiek = rok - 1900 - cyfryZPesela;
            }
            else // if (cyfryZPesela < 23) //urodzony miedzy 2000 a 2023
            {
                wiek = rok - 2000 - cyfryZPesela;
            }

            return wiek;
        }

        public string getGender()
        {
            string gender;
            int liczba = Convert.ToInt32(Pesel.Substring(9, 1));
            if (liczba % 2 == 0)
            {
                gender = "kobieta";
            }
            else
            {
                gender = "mężczyzna";
            }
            return gender;
        }

        public virtual string GetEducationInfo()
        {
            return "Czy uczeń może sam wracać do domu?";
        }

        public string GetFullName()
        {
            return Imie +" "+ Nazwisko;
        }

        public Boolean CanGoAloneToHome()
        {
            Boolean yesOrNo = false;
            if (this.GetAge() > 11)
            {
                yesOrNo = true;
            }
            return yesOrNo;
        }


    }
}
