
   
   Algorithm : An algorithm is a set of instructions to perform a task or to solve a given problem.

                 
   
    --------   T Y P E S   O F   D A T A   S T R U C T U R E S  --------------

    1  Linear Data Structure

        * Array
        * Linked List
        * Stack
        * Queue
    
    2  Non - Linear Data Structurs

        * Tree
        * Graph
  
    --------   T I M E  C O M P L E X I T Y  --------------

    * Its amount of time taken by algorithm to run.
    * The input processed by an algorithm helps in determining the time complexity.
  
    --------   S P A C E  C O M P L E X I T Y  --------------

    * Its amount of memory or space taken by algorithm to run. 
    * The memory required to process the input by an algorithm helps in determining the space complexity.
  
    --------   A S Y M P T O T I C   A N A L Y S I S  --------------

    * Asymptotic analysis helps in evaluating performance of an algorithm in terms of input size and its increase.
    * Using asymptotic analysis we dont messure actual running time of algorithm.
    * It helps in determining how time and space taken by algorithm increses with input size.
  
    --------   A S Y M P T O T I C   N O T A T I O N  --------------

    * Asymptotic notations are the mathematical tools used to describe the running time of an terms of input size.
    
    Ex :    Performance of car in 1 liter of petrol

    Highway        - 25 km/liter
    City           - 15 km/liter
    city + Highway - 20km/liter


    # Asymptotics Notation helps to determining  -
     
    1. Best Case       - Highway        - 25 km/liter
    2. Average Case    - City + Highway - 20km/liter
    3. Worst Case      - City           - 15 km/liter

    --------   T Y P E S    O F   A S Y M P T O T I C    N O T A T I O N  --------------

    * There are three notation for performing runtime analysis of an algorithm -
  
        1. Omega(-◠-) Notation :  
            
            * It is the formal way to express the lower bound of an algorithm's running time.
            * Lower bound means for any given input this notation determines best amount of time an algorithm can take to complete.
            * Ex - If we say certain algorithm takes 100 sec as best amount of time. So,100 sec will be lower bound of that algorithm. The algorithm can take more than 100 (>100)sec but it will not take less than 100 sec. 

        2. Big O(O) Notation : 

            * It is the formal way to express the upper bound of an algorithms running time.
            * Upper bound means for any given input this notation determines longest amount of time an algorithm can take to compelete.
            * Ex - If we say certain algorithm takes 100 sec as longest amount of time. So, 100 sec will be upper bound of that algorithm. The algorithm can take less than 100 (<100) sec but it will not take more than 100 sec.

        3. Theta(0) Notation : 
            * It is the formal way to express both the upper and lower bound of an algorithms running time.
            * By lower and upper bound means for any given input this notation determines average amount of time an algorithm can take to compelete.
            * Ex - If we run certain algorithm and it takes 100 sec for first run, 120 sec for second run ,110 for third run and so on. So theta notations gives an average of running time of that algorithm.
        
  
    --------   A N A L Y S I S  O F  T I M E   C O M P L E X I T Y  --------------

    1. Big O(O) Notation : 

        * It is the formal way to express the upper bound of an algorithms running time.
        * Upper bound means for any given input this notation determines longest amount of time an algorithm can take to compelete.
        * Rules of Big O(O) Notaion 
  
            1. Its a single processor
            2. It performs sequential execution of statemets.
            3. Assignment operation takes 1 unit of time. // int x = 10;
            4. Return statement takes in 1 unit of time.  // return x;
            5. Arithmatic operation takes 1 unit of time . // x+y;
            6. Logical operation takes 1 unit of time.  // x && y ;
            7. Other small and single operation takes 1 unit of times.    
            8. Drop lower order terms.  // T = n^2 + 3n+1==>O(n^2);
            9. Drop constant multiplier. // T = 3n^2 + 6n + 1 ==> O(n^2);

    --------   C A L C U L A T I N G   T I M E   C O M P L E X I T Y   O F   C O N S T A N T    A L G O R I T H M  --------------

    *