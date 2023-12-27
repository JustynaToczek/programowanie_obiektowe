using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zad2
{
    internal class WyjatekNullPointerException : ApplicationException
    {
        public WyjatekNullPointerException() : base("Null Pointer Exception - wyjątek własny")
        {
            
        }
    }
}
