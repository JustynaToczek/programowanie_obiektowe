using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Person
    {
        public string Name { get; set; }
        public string Surname { get; set; }
        public Address Address { get; set; }
        public string PersonalIDNumber { get; set; }
        public string Email {  get; set; }

        public Person() { }

        //public Person(string name, string surname, Address address, string personalIDNumber, string email)
        //{
        //    if (name == null) throw new ArgumentNullException("name");
        //    Name = name;
        //    Surname = surname;
        //    Address = address;

        //    if (personalIDNumber.Length != 11)
        //        throw new ArgumentException("Wprowadzono niepopraną długość numeru pesel!");

        //    PersonalIDNumber = personalIDNumber;


        //    if (!email.Contains("@"))
        //        throw new ArgumentException("Wprowadzono niepoprawny adres emial!");
        //    Email = email;
        //}
    }
}
