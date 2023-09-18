package exercises;

// суммарно потраченное время на решение - примерно 2 часа

public class _03_09_VampireNumber {
    static void VampireNumber() {
        Integer[] nums = new Integer[4];
        for (int i = 1011; i < 9999; i++) {

//            i = 1395;
            int test_num = i;
//            System.out.println("Test num " + test_num);
//            System.out.println("Start testing " + i);
            int last_digit = i % 10;
            int temp_i = i / 10;

            int counter = 0;
            nums[counter] = last_digit;
            counter++;

            while (temp_i != 0) {
                last_digit = temp_i % 10;
                nums[counter] = last_digit;
                temp_i = temp_i / 10;
                counter++;
            }

            outer:
            for (int z = 0; z < 4; z++) {
//                System.out.println("Test for z = " + z);
                for (int j = 0; j < 4; j++) {
                    if (z == j) {
                        continue;
                    }

                    int first_num = nums[z];
                    int second_num = nums[j];

                    int forth_num = 0;
                    int third_num = 0;

                    int h_ind = 0;
                    for (int h = 0; h < 4; h++) {
                        if (h != z && h != j) {
                            third_num = nums[h];
                            h_ind = h;
                            break;
                        }
                    }
                    for (int q = 0; q < 4; q++) {
                        if (q != z && q != j && q != h_ind) {
                            forth_num = nums[q];
                            break;
                        }
                    }

                    int first_part = Integer.parseInt(first_num + Integer.toString(second_num));
                    int sec_part1 = Integer.parseInt(Integer.toString(third_num) + forth_num);
                    int sec_part2 = Integer.parseInt(Integer.toString(forth_num) + Integer.toString(third_num));
//                    System.out.println(first_part + " " + sec_part1 + " " + sec_part2);


                    boolean condition = (first_part % 10 == 0 && sec_part2 % 10 == 0) || (Integer.toString(first_part).length() < 2 || Integer.toString(sec_part2).length() < 2);
                    if ((first_part % 10 == 0 && sec_part1 % 10 == 0) || (Integer.toString(first_part).length() < 2 || Integer.toString(sec_part1).length() < 2)) {
                        if (condition) {
                            continue;
                        } else {
                            int final_num = first_part * sec_part2;
                            if (final_num == test_num) {
                                System.out.println("Finded1! the number is: " + final_num);
                                break outer;
                            }
                        }
                    } else {
                        int final_num = first_part * sec_part1;
                        if (final_num == test_num) {
                            System.out.println("Finded2! the number is: " + final_num);
                            break outer;
                        } else {
                            if (!condition) {
                                int final_num2 = first_part * sec_part2;
                                if (final_num2 == test_num) {
                                    System.out.println("Finded3! the number is: " + final_num2);
                                    break outer;
                                }
                            }
                        }

                    }
                }
            }
//            break;
        }

    }

    public static void main(String[] args) {
        VampireNumber();
    }
}
