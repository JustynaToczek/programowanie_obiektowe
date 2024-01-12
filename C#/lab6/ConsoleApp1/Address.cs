using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Schema;

namespace ConsoleApp1
{
    internal class Address
    {
        public string City {  get; set; }
        public string Street { get; set; }
        public string FlatNumber { get; set; }

        public Address() { }
        public Address(string city, string street, string flatNumber)
        {
            City = city;
            Street = street;
            FlatNumber = flatNumber;
        }

        public override string ToString()
        {
            return $"Miasto: {City}, Ulica: {Street}, Numer mieszkania: {FlatNumber}";
        }
    }
}
