public class LemonadeStand
{
    private static boolean isChangeAvailable(int[] bills)
    {
        int fives = 0;
        int tens = 0;
        int twenties = 0;

        for (int payment : bills)
        {
            switch (payment)
            {
                case 5:
                    fives++;
                    break;

                case 10:
                    if (fives == 0)
                        return false;

                    fives--;
                    tens++;
                    break;

                case 20:
                    if (fives >= 1 && tens >= 1)
                    {
                        tens--;
                        fives--;
                    }
                    else if (fives >= 3)
                    {
                        fives -= 3;
                    }
                    else
                        return false;

                    twenties++;
                    break;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(isChangeAvailable(new int[]{5, 5, 5, 10, 20}));
        System.out.println(isChangeAvailable(new int[]{5, 5, 10, 10, 20}));
        System.out.println(isChangeAvailable(new int[]{10, 10}));
        System.out.println(isChangeAvailable(new int[]{5, 5, 5, 10}));
    }
}