using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zad4
{
    internal class MojTypDanych
    {
        public string Przedmiot {  get; set; }
        public int Cena { get; set; }

        public MojTypDanych(string przedmiot, int cena)
        {
            Przedmiot = przedmiot;
            Cena = cena;
        }

        
    }
}
