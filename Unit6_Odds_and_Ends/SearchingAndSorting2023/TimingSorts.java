import java.util.Random;
import acm.program.*;


public class TimingSorts extends ConsoleProgram
{
    private  final int CUTOFF = 53;
    private  final double TIME_DIV = 1000.0;
    
    public void run()
    {   
        if (!testSorts()) {return;}
            
        doTiming(1000);
        doTiming(5000);
        doTiming(10000);
        doTiming(50000);
             
        doTiming(100000);
        doTiming(500000);
        
        doTiming(5000000);
        doTiming(10000000);
        
        doTiming(50000000);  
        
       
    }

    private void doTiming (int size)
    {
        int[] test;
        long stop, start;
        
        println("*** Array size = " + size );
        
        test = randomArray(size);
        start = System.currentTimeMillis();
        bubbleSort(test);
        stop = System.currentTimeMillis();
        println("Bubble sort = " + (stop-start)/TIME_DIV);
         
        test = randomArray(size);
        start = System.currentTimeMillis();
        selectSort(test);
        stop = System.currentTimeMillis();
        println("Selection sort = " + (stop-start)/TIME_DIV);
            
        test = randomArray(size);
        start = System.currentTimeMillis();
        insertionSort(test);
        stop = System.currentTimeMillis();
        println("Insertion sort = " + (stop-start)/TIME_DIV);
        
        test = randomArray(size);
        start = System.currentTimeMillis();
        mergeSort(test);
        stop = System.currentTimeMillis();
        println("Merge sort = " + (stop-start)/TIME_DIV);
                  
        test = randomArray(size);
        start = System.currentTimeMillis();
        quickSort(test);
        stop = System.currentTimeMillis();
        println("Quick sort = " + (stop-start)/TIME_DIV);
        
        println();
        
    }
    
    private boolean isSorted(int[] a)
    {
        for (int k=0; k < a.length-1; k++)
        {
            if (a[k] > a[k+1]) return false;
        }
        return true;
    }
    
    private int[] randomArray(int len)
    {
        Random r = new Random();
    
        int[] temp = new int[len];
        
        for (int k = 0; k < len; k++)
        {
            temp[k] = r.nextInt(100000);
        }
        
        return temp;
    }
    
    
    private void swap (int[] a, int j, int k)
    {
        int temp = a[k];
        a[k] = a[j];
        a[j] = temp;
    }
    
    public void bubbleSort(int[] a)
    {
        int j,k;
        boolean madeswap;
        for(j=a.length-1; j > 0; j--)
        {
            madeswap = false;
                for(k=0; k < j; k++)
            {
                if (a[k+1] < a[k])
                {
                    madeswap = true;
                    swap(a,k,k+1);
                }
            }
            if (!madeswap) return;  
        }
    }
    
    public void selectSort(int[] a)
    {
        int j,k,min;
        
        for(j=0; j< a.length-1;j++)
        {
            min = j;
            for(k=j+1; k<a.length; k++)
            {
                if (a[k] < a[min])
                    { min = k;}
            }
            swap(a,min,j);
        }    
    }
    
    private void insertionSort(int[]a ,int first, int last)
    {
        int k,loc;
        
        for(k=first +1;k<=last;k++) 
        {
            // shift elements to make room for A[k]
            int hold = a[k];   // insert this element
            loc = k;            // location for insertion
            while (first < loc  && hold < a[loc-1])
            {
                a[loc] = a[loc-1];
                loc--;
            }
            a[loc] = hold;
        }
    }
    
    
    public void insertionSort(int[] a)
    {
      insertionSort(a, 0, a.length-1);
    }
    
    
    private void merge(int[] a, int[] b, int left,int mid,int right)
    // precondition: A sorted from A[left] ... A[mid] and from
    //               A[mid+1] to A[right], extra storage passed in as Array B
    // postcondition: A sorted from A[left] ... A[right]     
    {
        int lk=left;                          // a's left index 
        int rk = mid+1;                       // a's right index 
        int bk = left;                        // b's index
        
        while (lk <= mid && rk <= right)      // both parts non-empty?
        {
            if (a[lk]< a[rk])
            {
                b[bk] = a[lk];
                lk++;
            }
            else
            {
                b[bk] = a[rk];
                rk++;
            }
            bk++;
        }
            // finish any leftovers in a (only one of loops below executes)
        while (lk <= mid)
        {
            b[bk] = a[lk];
            bk++;
            lk++;
        }
        while(rk <= right)
        {
            b[bk] = a[rk];
            bk++;
            rk++;
        }
        
            // copy B back to A
        
        for(lk=left; lk <= right; lk++)
        {
            a[lk] = b[lk];
        }
    }
    
    
    private void mergeSort(int[] a, int[] temp, int left,int right)
    // postcondition: A[left] <= ... <= A[right],
    //                temp.length() == A.length(), temp is temp array for merging    
    {
        int mid = (left+right)/2;
        
        if (right - left > CUTOFF)
        {
            mergeSort(a, temp, left, mid);
            mergeSort(a, temp, mid+1, right);
            merge(a, temp, left, mid, right);
        }
        else
        {
            insertionSort(a, left, right);
        }
    }
   
    public void mergeSort(int[] a)
    {
        int[] temp = new int[a.length];
        
        mergeSort(a, temp, 0, a.length-1);
    
    }
        
    private int pivot(int[] a,int first,int last)
    // postcondition: returns piv such that
    //                first <= k <= piv, a[k] <= a[piv]
    //                piv < k <= last, a[piv] < a[k]                
    {
        int k;
        int p=first;
    
        for(k=first+1;k<=last;k++)
        {
            if (a[k] <= a[first])
            {
                p++;            
                swap(a,k,p);
            }
        }
        swap(a,p,first);
        return p;
    }
    
    private void quickSort(int[] a,int first,int last)
    // postcondition: a[first] <= ... <= a[list]     
    {
        int piv;
        
        if (last - first > CUTOFF)
        {
            piv = pivot(a,first,last);
            quickSort(a,first,piv-1);
            quickSort(a,piv+1,last);
        }
        else
        {
            insertionSort(a, first, last);
        }
    }
    
    public void quickSort(int[] a)
    {
        quickSort(a, 0, a.length-1);
    }
    
    private void heapify(int[] a, int vroot, int size)
    // precondition: subheaps of vroot are heaps: shape and property
    // postcondition: heap rooted at vroot is a heap
    {
        int rootval = a[vroot];
        int child;
        int k = vroot;
        
        while (2*k+1 < size)
        {
            child = 2*k+1;                       
            
            // if there's a right child, and it's bigger, move the larger
            if (child+1 < size && a[child] < a[child+1])
            {
                child++;
            }
            if (a[child] < rootval) break;
            
            a[k] = a[child];
            k = child;
        }
        a[k] = rootval;
    }
    
    private void heapSort(int[] a, int size)
    {
        int k;
        
        for(k=(size-2)/2; k >= 0; k--)
        {
            heapify(a,k,size);
        }
        for(k=size-1; k >= 1; k--)
        {
            swap(a,0,k);
            heapify(a,0,k);
        }
    }
    
    public void heapSort(int[] a)
    {
        heapSort(a, a.length);
    }
    
    private boolean testSorts()
    {
            
        println("Testing sorting algorithms...");
        
        int[] testVec = randomArray(200);
        bubbleSort(testVec);
        if (!isSorted(testVec)) {println("Bubble sort doesn't work!"); return false;}
        println("Bubble sort works...");
        
        testVec = randomArray(200);
        selectSort(testVec);
        if (!isSorted(testVec)) {println("Selection sort doesn't work!"); return false;}
        println("Selection sort works...");
    
        testVec = randomArray(200);
        insertionSort(testVec);
        if (!isSorted(testVec)) {println("Insertion sort doesn't work!"); return false;}
        println("Insertion sort works...");
    
        testVec = randomArray(200);
        mergeSort(testVec);
        if (!isSorted(testVec)) {println("Merge sort doesn't work!"); return false;}
        println("Merge sort works...");
    
        testVec = randomArray(200);
        quickSort(testVec);
        if (!isSorted(testVec)) {println("Quick sort doesn't work!"); return false;}
        println("Quick sort works...");
    
        testVec = randomArray(200);
        heapSort(testVec);
        if (!isSorted(testVec)) {println("Heap sort doesn't work!"); return false;}
        println("Heap sort works...");
    
        println("All sorting algorithms work!");
        return true;
    }
    



}