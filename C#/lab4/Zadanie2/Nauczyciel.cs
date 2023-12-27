using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie2
{
    internal class Nauczyciel : Uczen
    {
        public string TytulNaukowy {  get; set; }
        public List<Uczen> PodwladniUczniowie { get; set; }

        public Nauczyciel(string imie, string nazwisko, string pesel, string szkola, string tytulNaukowy) : base(imie, nazwisko, pesel, szkola)
        {
            TytulNaukowy = tytulNaukowy;
            PodwladniUczniowie = new List<Uczen>();
        }

        public void WhichStudentCanGoHomeAlone()
        {
            Console.WriteLine("Uczniowie, którzy mogą pójść do domu sami:");
            foreach(Uczen item in PodwladniUczniowie)
            {
                if(item.MozeSamWracacDoDomu == true)
                {
                    Console.WriteLine(item.GetFullName());
                }
            }
        }
    }
}
