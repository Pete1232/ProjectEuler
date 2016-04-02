
#ProjectEuler
My solutions to the problems on projecteuler.net

##Project structure
The project is build at the top level with sbt to contain code that is/could be reusable across multiple problems. 
Each individual solution is also built as an sbt project.
This is all configured in build.sbt.

The code in the parent project can be put within the scope of a particular solution using the ```dependsOn``` keyword.
The code can then be imported as any other library (e.g. ```import integer.IntMethods```).
Note that IntelliJ (and probably other IDEs) will not resolve the import correctly, but it does work.

###Adding a new solution (for my reference)
* Add a new folder and scala script
* Add the new solution as a project in build.sbt (as in any of the other problems)
* Add the base project as a dependency as required (possibly moving code from another solution up a level if useful)