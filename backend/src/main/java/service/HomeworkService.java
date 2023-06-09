package service;

import models.Homework;
import org.springframework.stereotype.Component;
import repository.HomeworkRepository;
import utility.ScannerThis;
import utility.utilityLog.LogFactory;

import java.util.NoSuchElementException;
@Component
public class HomeworkService {

    public Homework createHomework() {
        return new Homework();
    }

    public void createHomeworkWithLectureId(int lectureId) {
        HomeworkRepository.getInstance().getHomeworkList().add(new Homework(lectureId));
        LogFactory.debug(this.getClass().getName(), "Create new homework with lectureId");

    }


    public void createHomeworkWithLectureIdAndName(int lectureId, String task) {
        HomeworkRepository.getInstance().getHomeworkList().add(new Homework(lectureId, task));
    }

    public Homework createHomeworkWithTask(String task) {
        return new Homework(task);
    }


    public void shoveHomeworkTreeMapWithOptions() {
        System.out.println(HomeworkRepository.getInstance().homeworkTreeMap());
        String answer;
        do {
            System.out.println("Do you want to add or remove  Homework? [Y/N]");
            answer = ScannerThis.getInstance().nextLine();
        }
        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
        if (answer.equalsIgnoreCase("y")) {
            int answerDo;
            do {
                System.out.println("""
                        Select the desired action number:
                        1 Add the new Homework;
                        2 Remove the exist Homework.""");
                answerDo = ScannerThis.getInstance().nextInt();
                ScannerThis.getInstance().nextLine();
            }
            while (answerDo < 1 | answerDo > 2);
            if (answerDo == 1) {
                int freeId = HomeworkRepository.getInstance().homeworkTreeMap().lastKey() + 1;
                System.out.println("Enter a lectureId for the new Homework (" + freeId + "):");
                int lectureId = ScannerThis.getInstance().nextInt();
                ScannerThis.getInstance().nextLine();
                new HomeworkService().createHomeworkWithLectureId(lectureId);
                System.out.println(HomeworkRepository.getInstance().homeworkTreeMap());

            } else {
                System.out.println("Enter a lectureId to remove Homework:");
                int lectureId = ScannerThis.getInstance().nextInt();
                ScannerThis.getInstance().nextLine();
                boolean flag = false;
                for (Homework homework : HomeworkRepository.getInstance().getHomeworkList()) {
                    if (homework.getLectureId() == lectureId) {
                        flag = true;
                        HomeworkRepository.getInstance().getHomeworkList().remove(homework);
                        break;
                    }
                }
                if (!flag) {
                    throw new NoSuchElementException();
                }

                System.out.println(HomeworkRepository.getInstance().homeworkTreeMap());

            }

        } else {
            System.out.println("You refused to make changes!");
        }

    }

    public void homeworkRemoveMenu(int lectureId) {


        boolean flag = false;
        for (Homework homework : HomeworkRepository.getInstance().getHomeworkList()) {
            if (homework.getLectureId() == lectureId) {
                flag = true;
                HomeworkRepository.getInstance().getHomeworkList().remove(homework);
                LogFactory.debug(this.getClass().getName(), "Remove the homework with lectureId = " + lectureId);
                break;
            }
        }
        if (!flag) {

            NoSuchElementException e = new NoSuchElementException();
            LogFactory.warning(this.getClass().getName(), "Id don't exist", e.getStackTrace());

            throw e;
        }
    }


}


