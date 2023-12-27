using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zad2
{
    internal class WyjatekClassNotFound : ApplicationException
    {
        public WyjatekClassNotFound() : base("wyjatek nie znaleziono klasy - wyjątek własny") 
        { }
    }
}
