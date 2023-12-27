using Zadanie2;

Uczen uczen1 = new Uczen("Tomek","Tomowski", "04221338454","szkola podstawowa nr 4");
Uczen uczen2 = new Uczen("Ala","Alowak", "15221338454","szkola podstawowa nr 4");


Nauczyciel nauczyciel = new Nauczyciel("Jan","Kowalski","99999","szkola podstawowa nr 4","magister");
nauczyciel.PodwladniUczniowie.Add(uczen1);
nauczyciel.PodwladniUczniowie.Add(uczen2);

nauczyciel.WhichStudentCanGoHomeAlone();