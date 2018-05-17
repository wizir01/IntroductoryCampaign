package service;

import dao.DaoExams;
import dao.DaoSubject;
import factory.DaoFactory;
import model.Exams;
import model.Subject;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class ExamsService implements IService {
    private final DaoExams daoExams = DaoFactory.getInstance().getDaoExams();
    private final DaoSubject daoSubject = DaoFactory.getInstance().getDaoSubject();

    public void create(User user, List<Subject> subjects) {
        for (Subject subject : subjects) {
            daoExams.create(subject.getId(), user.getId());
        }
    }

    public List<Exams> getAll() {
        return daoExams.getAll();
    }

    public List<Exams> getByUser(int User_id) {
        return daoExams.getByUserId(User_id);
    }

    public List<Subject> getSubjectsByUser(int User_id) {
        List<Subject> subjects = new ArrayList<>();
        List<Exams> exams = getByUser(User_id);

        for (Exams exam : exams) {
            Subject subject = daoSubject.get(exam.getSubjectId());
            subjects.add(subject);
        }
        return subjects;
    }

    public void setMark(int Exams_id, int Mark) {
        daoExams.setMark(Exams_id, Mark);
    }
}
