package com.company;
//Mahathi Athreya 3B
/***
 Consider a grading scheme where your final grade is computed more generously
 if your grades show improvement over the term.  Scores show improvement
 if each grade is greater than or equal to the previous grade.

 A student has x scores indexed from 0 to x-1.  If the scores have shown improvement
 only those grades with indexes greater than to equal to x/2 are averaged.  If the
 scores have not improved, all of the scores are averaged.
 ***/

public class GradeAverage {

    private int [] scores;

    public GradeAverage(int [] s)
    {
        scores = s;
    }
    // returns the mean (average) of the values in the scores array
    // whose indexes are between first and last (including first and last).
    //You may assume that first and last are > 0 and < scores.length
    public double mean(int first, int last)
    {
        int x = first;
        double y = 0.0;
        while (x <= last) {
            y+=scores[x];
            x++;
        }
        y/=(last-first+1);
        return y;


    }

    // returns true if each successive value in scores is greater than
    // or equal to the previous value.  Otherwise returns false
    private boolean showsImprovement()
    {
        int x = 0;
        for(int i=1; i<scores.length; i++) {
            if (scores[i] >= scores[i-1]) {
                x++;
            }
        }
        if (x == scores.length-1) {
            return true;
        }

        return false;
    }

    // if the values in the scores array show improvement, returns the
    // average of the elements in scores with indexes greater than or
    // equal to scores.length()/2
    public double finalGrade()
    {
        int w = scores.length/2;
        double j =0.0;
        boolean a = showsImprovement();
        if (a == true) {
            j = mean(w, scores.length-1);
        }
        else {
            j = mean(0, scores.length-1);
        }
        return j;
    }
    public static void main(String[] args) {
        int [] s1 = {50,50,20,80,53};   // not improved, finalGrade is 50.6
        int [] s2 = {20,50,50,53,80};   // improved, final grade is 61.0
        int [] s3 = {20,50,50,80};      // improved, final grade is 65.0

        GradeAverage sr1 = new GradeAverage(s1);
        System.out.println(sr1.mean(1, 3));
        System.out.println(sr1.showsImprovement());
        System.out.println(sr1.finalGrade());
        GradeAverage sr2 = new GradeAverage(s2);
        System.out.println(sr2.mean(0, 3));
        System.out.println(sr2.showsImprovement());
        System.out.println(sr2.finalGrade());
        GradeAverage sr3 = new GradeAverage(s3);
        System.out.println(sr3.mean(1, 3));
        System.out.println(sr3.showsImprovement());
        System.out.println(sr3.finalGrade());
    }

}
/*
Results:
sr1:
mean: 50.0
showsImprovement: false
finalGrade: 50.6
sr2:
mean: 43.25
showsImprovement: true
finalGrade: 61.0
sr3
mean: 60.0
showsImprovement: true
finalGrade: 65.0

 */
