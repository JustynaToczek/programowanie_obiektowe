﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zad2
{
    internal class WyjatekDivideByZero : ApplicationException
    {
        public WyjatekDivideByZero() : base("Dzielenie przez zero Exception - wyjątek własny")
        {
        }
    }
}
