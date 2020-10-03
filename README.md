# Analysis-using-Apache-Spark


This Project is for analysing (Histogram clustering) using Spark and Scala. 

Scripts to build and run this code on Comet (https://www.sdsc.edu/support/user_guides/comet.html) are provided. 

The main program takes one argument: 

The text file that contains the pixels (pixels-small.txt or pixels-large.txt). 

The resulting histograms is written to the output. A pair of two integers is used, one for the color type and one for the color intensity.



You can compile Histogram.scala using:
```
run histogram.build
```
and you can run it in local mode over the small file using:
```
sbatch histogram.local.run
```
You should modify and run your programs in local mode until you get the correct result. Your output results must be the same as the solution-small.txt but doesn't have to be in the same order. After you make sure that your program runs correctly in local mode, you run it in distributed mode using:
```
sbatch histogram.distr.run
```
This will work on the moderate-sized file and will print the results to the output.
