using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie3
{
    internal interface IOsoba
    {
        string Imie { get; set; }
        string Nazwisko { get; set; }
        string ZwrocPelnaNazwe();

    }
}
