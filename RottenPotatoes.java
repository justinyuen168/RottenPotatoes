public class RottenPotatoes {
    public static void main (String[] args) {
    int[][] ratings = { {4,6,2,5},
                        {7,9,4,8},
                        {6,9,3,7} };
   int rating0 = movieRating(ratings,0);
   System.out.println("Movie zero's average rating: " + rating0);
   int rating1 = movieRating(ratings,1);
   System.out.println("Movie one's average rating: " + rating1);
    int rating2 = movieRating(ratings,2);
   System.out.println("Movie two's average rating: " + rating2);   
   System.out.println("The hardest reviewer is #" + hardest(ratings));
   System.out.println("The worst movie is #" + worst(ratings));
    }
    public static int movieRating(int[][] ratings, int movie) {
        double sum = 0;
        for (int r = 0; r < ratings.length; r++) {
            sum += ratings[r][movie];
        }
        return (int)(sum/ratings.length);  
    }
    public static int reviewRating(int[][] ratings,int reviewer) {
        double sum = 0;
        for (int a = 0; a < ratings[0].length; a++) {
            sum += ratings[reviewer][a];
        }
        return (int)(sum/ratings[0].length);
    }
    public static int avgRating(int[][] ratings) {
        double sum = 0;
        double numRatings = ratings.length * ratings[0].length;
        for (int r = 0; r < ratings.length; r++) {
            for (int c = 0; c < ratings[0].length; c++) {
                sum += ratings[r][c];
            }
        }
        return (int)(sum/numRatings);
    }
    public static int hardest(int[][] ratings) {
        int hardAvg = reviewRating(ratings, 0);
        int hardestIndex = 0;
        for (int r = 1; r < ratings.length; r++) {
            int newAvg =  reviewRating(ratings, r);
            if (newAvg < hardAvg) {
                hardestIndex = r;
                hardAvg = newAvg;
            }
        }
        return hardestIndex;
    }
    public static int worst(int[][] ratings) {
        int Avg = reviewRating(ratings, 0);
        int worstIndex = 0;
        for (int c = 1; c < ratings[0].length; c++) {
            int newAvg =movieRating(ratings, c);
            if (newAvg < Avg) {
                worstIndex = c;
                Avg = newAvg;
            }
        }
        return worstIndex;
    }   
}