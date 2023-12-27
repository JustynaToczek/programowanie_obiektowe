using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie2
{
    internal class Uczen : Osoba
    {
        public string Szkola {  get; set; }
        public Boolean MozeSamWracacDoDomu {  get; set; }

        public Uczen(string imie, string nazwisko, string pesel, string szkola) : base(imie, nazwisko, pesel)
        {
            Szkola = szkola;
            MozeSamWracacDoDomu = CanGoAloneToHome();
        }

        public void SetSchool(string school)
        {
            Szkola = school;
        }

        public void ChangeSchool(string newSchool)
        {
            Szkola = newSchool;
        }

        public void setCanGoHomeAlone()
        {
            MozeSamWracacDoDomu = CanGoAloneToHome(); //wywolanie matody z klasy bazowej
        }

        public override string GetEducationInfo()
        {
            if(MozeSamWracacDoDomu == true)
            {
                return base.GetEducationInfo() + "\nTak, uczeń może wracać sam do domu";
            }
            else
            {
                return base.GetEducationInfo() + "\nNie, uczeń nie może wracać sam do domu, chyba, że ma pozwolenie";
            }
            
            
        }
    }
}
