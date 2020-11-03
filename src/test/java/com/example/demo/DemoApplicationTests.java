//package com.example.demo;
//
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DemoApplicationTests {
//
//   public int getResult(String startDate1,String endDate1,String startDate2,String endDate2){
//
//          int start1 = formatDatetoInt(startDate1);
//          int end1 = formatDatetoInt(endDate1);
//          int start2 = formatDatetoInt(startDate2);
//          int end2 = formatDatetoInt(endDate2);
//          int month = 0;
//       if(end1 >= start2 && end1 <end2 && start2 > start1) {
//               month = end1 - start2;
//          }else if (end1 >= start2 && end1 <end2 && start2 < start1 || end2 > end1 && start2 > start1){
//               month = end1 - start1;
//          }else if (end1 <= start2 && end1 >end2 && start2 < start1){
//           month = start2 - end1;
//          }else if (end1 <= start2 && end1 >end2 && start2 > start1 || end2 < end1 && start2 < start1){
//           month = start1 - end1;
//          }else if(end2 < end1 && start2 >start1 ){
//           month = end2 - start2;
//       }
//       if(month > 12){
//              String monthstr = String.valueOf(month);
//              month =  Integer.parseInt(monthstr.substring(0,monthstr.length()-2)) * 12
//                     + Integer.parseInt(monthstr.substring(monthstr.length()-2,monthstr.length())) ;
//       }
//       return  month;
//   }
//
//    public static void main(String[] args) throws ParseException {
////        String startDate1 = "2015-05";
////        String endDate1 = "2018-10";
////        String startDate2 = "2017-06";
////        String endDate2 = "2018-11";
////        DemoApplicationTests demoApplicationTests = new DemoApplicationTests();
//////        int result = demoApplicationTests.getResult(startDate1, endDate1, startDate2, endDate2);
////        int result = demoApplicationTests.getResult2(startDate1, endDate1, startDate2, endDate2);
////        System.out.print(result);
//        Date date = new Date(String.valueOf(201802));
//        System.out.println(date);
//    }
//
//    public int formatDatetoInt(String date){
//       return Integer.parseInt(date.replace("-",""));
//    }
//
//    public int getResult2(String startDate1,String endDate1,String startDate2,String endDate2) throws ParseException {
//        int start1 = formatDatetoInt(startDate1);
//        int end1 = formatDatetoInt(endDate1);
//        int start2 = formatDatetoInt(startDate2);
//        int end2 = formatDatetoInt(endDate2);
//        int latest_start = 0;
//        if(start1 > start2){
//            latest_start = start1;
//        }else {
//            latest_start = start2;
//        }
//
//       int earliest_end = 0;
//        if(end1 > end2){
//            earliest_end = end2;
//        }else {
//            earliest_end = end1;
//        }
//       int overlap = earliest_end - latest_start;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
//
//        int month = getMonth(simpleDateFormat.parse(String.valueOf(earliest_end)), simpleDateFormat.parse(String.valueOf(earliest_end)));
//        if (overlap < 0){
//        overlap = 0;}
//
//        if(overlap > 12){
//            String monthstr = String.valueOf(overlap);
//            overlap =  Integer.parseInt(monthstr.substring(0,monthstr.length()-2)) * 12
//                    + Integer.parseInt(monthstr.substring(monthstr.length()-2,monthstr.length())) ;
//        }
//        return overlap;
//    }
//    /**
//     * 获取两个日期相差几个月
//     * @author 石冬冬-Heil Hilter(dd.shi02@zuche.com)
//     * @date 2016-11-30 下午7:57:32
//     * @param start
//     * @param end
//     * @return
//     */
//    public static int getMonth(Date start, Date end) {
//        if (start.after(end)) {
//            Date t = start;
//            start = end;
//            end = t;
//        }
//        Calendar startCalendar = Calendar.getInstance();
//        startCalendar.setTime(start);
//        Calendar endCalendar = Calendar.getInstance();
//        endCalendar.setTime(end);
//        Calendar temp = Calendar.getInstance();
//        temp.setTime(end);
//        temp.add(Calendar.DATE, 1);
//
//        int year = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
//        int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
//
//        if ((startCalendar.get(Calendar.DATE) == 1)&& (temp.get(Calendar.DATE) == 1)) {
//            return year * 12 + month + 1;
//        } else if ((startCalendar.get(Calendar.DATE) != 1) && (temp.get(Calendar.DATE) == 1)) {
//            return year * 12 + month;
//        } else if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) != 1)) {
//            return year * 12 + month;
//        } else {
//            return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
//        }
//    }
//
//
//}
//
