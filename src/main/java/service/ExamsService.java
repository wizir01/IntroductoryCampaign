package service;

import dao.DaoExams;
import dao.DaoSubject;
import dao.DaoUser;
import factory.DaoFactory;
import model.Exams;
import model.ExamsExtra;
import model.Subject;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class ExamsService implements IExamsService {
    private final DaoExams daoExams = DaoFactory.getInstance().getDaoExams();
    private final DaoSubject daoSubject = DaoFactory.getInstance().getDaoSubject();
    private final DaoUser daoUser = DaoFactory.getInstance().getDaoUser();

    public boolean create (int subjectId, int userId) {
       return daoExams.create(subjectId, userId);
    }

    public List<ExamsExtra> createExtra(List<Exams> exams) {
        List<ExamsExtra> examsExtras = new ArrayList<>();
        for (Exams exam : exams) {
            examsExtras.add(new ExamsExtra(exam.getId(), daoSubject.get(exam.getSubjectId()).getName(), daoUser.get(exam.getUserId()).getName(), exam.getMark()));
        }
        return examsExtras;
    }

    public List<Exams> getAll() {
        return daoExams.getAll();
    }

    public List<ExamsExtra> getAllExtra() {
        return createExtra(getAll());
    }

    public List<Exams> getByUser(int User_id) {
        return daoExams.getByUserId(User_id);
    }

    public List<Integer> getSubjectIdByUser(int User_id) {
        List<Integer> result = new ArrayList<>();
        List<Exams> exams = getByUser(User_id);
        for (Exams exam : exams) {
            result.add(exam.getSubjectId());
        }
        return result;
    }

    public List<ExamsExtra> getByUserExtra(int User_id) {
        return createExtra(getByUser(User_id));
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

    public boolean setMark(int Exams_id, int Mark) {
        return daoExams.setMark(Exams_id, Mark);
    }
}
