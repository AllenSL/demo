package com.example.demo.ffmpeg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ValidateFile
 * @Description 使用ffmpeg检查文件类型等...操作
 * @Autor ansonglin
 * @Date 2019/5/30 10:46
 * @Version 1.0
 **/
@Slf4j
@RestController
public class FFMpegUtil {

    public static enum AudioType {
        amr, mp3, wav, unknown
    }

    public static String FFMPEGURI = "ffmpeg";

    public static AudioInfo getAudioInfo(String originFileUri) {
        return getAudioInfo(FFMPEGURI, originFileUri);
    }

    /**
     * 获取音频信息
     *
     * @param ffmpegUri     ffmpeg的全路径 如e:/ffmpeg/ffmpeg.exe 或 /usr/local/bin/ffmpeg
     * @param originFileUri 所操作视频文件的全路径 如e:/upload/temp/test.wmv
     * @return
     */
    public static AudioInfo getAudioInfo(String ffmpegUri, String originFileUri) {
        try {
            List<String> cmd = new ArrayList<String>();
            cmd.add(ffmpegUri);
//            cmd.add("-i");
            cmd.add("-show_format");
            cmd.add(originFileUri);
            List<String> strs = exec(cmd);
            AudioInfo ai = dealString(strs);
            ai.setPath(originFileUri);
//            AudioType audioType = getAudioType(ai);
            return ai;
        } catch (Exception e) {
            log.error("获取音频信息错误:", e);
        }
        return null;
    }

//    /**
//     * 获取音频编码
//     *
//     * @param ai
//     * @return
//     */
//    public static AudioType getAudioType(AudioInfo ai) {
//        if (ai.getAudio().toLowerCase().contains("amr")) {
//            return FFMpegUtil.AudioType.amr;
//        } else if (ai.getAudio().toLowerCase().contains("mp3")) {
//            return FFMpegUtil.AudioType.mp3;
//        } else if (ai.getAudio().toLowerCase().contains("wav")) {
//            return FFMpegUtil.AudioType.wav;
//        }
//        return FFMpegUtil.AudioType.unknown;
//
//    }


    /**
     * 执行指令
     *
     * @param cmd    执行指令
     */
    static public List<String> exec(List<String> cmd) {
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(cmd);
            builder.redirectErrorStream(true);
            Process proc = builder.start();
            BufferedReader stdout = new BufferedReader(
                    new InputStreamReader(proc.getInputStream()));
            List<String> strs = new ArrayList<String>();
            String line;
            while ((line = stdout.readLine()) != null) {
                strs.add(line);
            }

            proc.waitFor();
            stdout.close();
            return strs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static String DURATION = "Duration";
    static String BITRATE = "bitrate";
    static String AUDIO = "Audio";
    static String FORMAT_NAME = "format_name";

    public static AudioInfo dealString(List<String> strs) {
        System.out.println("音频信息：" + strs);
        AudioInfo ai = new AudioInfo();
        for (String str : strs) {
//            if (str.contains(DURATION)) {
//                String bak = str.substring(str.indexOf(DURATION) + DURATION.length());
//                String temp = bak.substring(bak.indexOf(":") + 1, bak.indexOf(","));
//                if (temp != null) {
//                    ai.setDuration(getLongTime(temp));
//                }
//            }
//            if (str.contains(BITRATE)) {
//                String bak = str.substring(str.indexOf(BITRATE) + BITRATE.length());
//                String temp = bak.substring(bak.indexOf(":") + 1, bak.lastIndexOf(" "));
//                if (temp != null) {
//                    ai.setBitrate(temp.trim());
//                }
//            }
//            if (str.contains(AUDIO)) {
//                String bak = str.substring(str.indexOf(AUDIO) + AUDIO.length());
//                String temp = bak.substring(bak.indexOf(":") + 1, bak.indexOf(","));
//                if (temp != null) {
//                    ai.setAudio(temp.trim());
//                }
//            }
            if (str.contains(FORMAT_NAME)) {
                String bak = str.substring(str.indexOf(FORMAT_NAME) + FORMAT_NAME.length());
                String temp = bak.substring(bak.indexOf("=") + 1);
                if (temp != null) {
//                    ai.setAudio(temp.trim());
                }
            }
        }
        return ai;
    }

    public static int getLongTime(String str) {
        int t = Integer.parseInt(str.substring(1, 3)) * 60 * 60 + Integer.parseInt(str.substring(4, 6)) * 60 + Integer.parseInt(str.substring(7, 9));
        return t;
    }

    /**
     * 将秒转成小时分秒
     *
     * @param time
     * @return
     */
    public static String getStringTime(int time) {
            //小时
        int h = time / 3600;
        int m = (time % 3600) / 60;
        int s = (time % 3600) % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }


    /**
     * 音频转码
     *
     * @param inputfile
     * @param outputfile
     */
    public static void transcode(String inputfile, String outputfile) {
        try {
            List<String> cmd = new ArrayList<String>();
            cmd.add(FFMPEGURI);
            cmd.add("-i");
            cmd.add(inputfile);
            cmd.add("-ac 1");
            cmd.add("-ar 8000");
            cmd.add("-ab 128");
            cmd.add(outputfile);
            exec(cmd);
        } catch (Exception e) {
            log.error("音频转码错误:", e);
        }
    }

    /**
     * 按照时长进行切片
     *
     * @param inputfile
     * @param duration
     */
//    public static void split(String inputfile, List<String> files, int duration) {
////        int start = 0;
////        while (start <= duration) {
////            String temp = FileUtil.getTempFile();
////            files.add(temp);
////            split(inputfile, temp, start, duration);
////            start = +duration;
////        }
////    }

    public static void split(String inputfile, String outputfile, int start, int duration) {
        try {
            List<String> cmd = new ArrayList<String>();
            cmd.add(FFMPEGURI);
            cmd.add("-ss");
            cmd.add(getStringTime(start));
            cmd.add("-i");
            cmd.add(inputfile);
            cmd.add("-c copy");
            cmd.add("-t");
            cmd.add(String.valueOf(duration));
            cmd.add(outputfile);
            exec(cmd);
        } catch (Exception e) {
            log.error("音频切片错误:", e);
        }
    }

    public static void main(String[] args) {
        String ffmepgPath = "D:\\person\\commonTools\\ffmpeg\\bin\\ffmpeg.exe";
        String ffprobePath = "D:\\person\\commonTools\\ffmpeg\\bin\\ffprobe.exe";
        String audioPath = "C:\\Users\\Administrator\\Desktop\\OSS测试文件\\fail.mp3";
        String videoPath = "C:\\Users\\Administrator\\Desktop\\1.flv";
        String picPath = "https://etgame-easy-word.oss-cn-beijing.aliyuncs.com/easy_word_video/word_video/absurd.mp4";
        File file = new File("sss");
        file.getPath();
        AudioInfo audioInfo = FFMpegUtil.getAudioInfo(ffprobePath, picPath);
    }

    @PostMapping("/qqq")
    public AudioInfo test(MultipartFile file){
        String localFile = createLocalFile(File_PATH, file);
        String ffmepgPath = "D:\\person\\commonTools\\ffmpeg\\bin\\ffmpeg.exe";
        String ffprobePath = "D:\\person\\commonTools\\ffmpeg\\bin\\ffprobe.exe";
        log.info("path:"+localFile);

        AudioInfo audioInfo = FFMpegUtil.getAudioInfo(ffprobePath, localFile);
        File file1 = new File(localFile);
        boolean delete = file1.delete();
        return audioInfo;
    }

    /**
     * windows下的文件路径
     */
    private final String File_PATH = "E:/upload/temp";

    /**
     * 通过上传的文件名，缓冲到本地，后面才能解压、验证
     * @param filePath 临时缓冲到本地的目录
     * @param file
     */
    public String createLocalFile(String filePath,MultipartFile file) {
        File localFile = new File(filePath);
        //先创建目录
        localFile.mkdirs();

        String originalFilename = file.getOriginalFilename();
        String path = filePath+"/"+originalFilename;

        log.info("createLocalFile path = {}", path);

        localFile = new File(path);
        FileOutputStream fos = null;
        InputStream in = null;
        try {

            if(localFile.exists()){
                //如果文件存在删除文件
                boolean delete = localFile.delete();
                if (delete == false){
                    log.error("Delete exist file \"{}\" failed!!!",path,new Exception("Delete exist file \""+path+"\" failed!!!"));
                }
            }
            //创建文件
            if(!localFile.exists()){
                //如果文件不存在，则创建新的文件
                localFile.createNewFile();
                log.info("Create file successfully,the file is {}",path);
            }

            //创建文件成功后，写入内容到文件里
            fos = new FileOutputStream(localFile);
            in = file.getInputStream();
            byte[] bytes = new byte[1024];

            int len = -1;

            while((len = in.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

            fos.flush();
            log.info("Reading uploaded file and buffering to local successfully!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fos != null) {
                    fos.close();
                }
                if(in != null) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("InputStream or OutputStream close error : {}", e);
            }
        }

        return path;
    }
}
   