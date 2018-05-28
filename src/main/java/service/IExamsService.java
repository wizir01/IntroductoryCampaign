package service;

import model.Exams;
import model.ExamsExtra;
import model.Subject;
import model.User;

import java.util.ArrayList;
import java.util.List;

public interface IExamsService extends IService {

    boolean create (int subjectId, int userId);

    List<ExamsExtra> createExtra(List<Exams> exams);

    List<Exams> getAll();

    List<ExamsExtra> getAllExtra();

    List<Exams> getByUser(int User_id);

    List<ExamsExtra> getByUserExtra(int User_id);

    List<Subject> getSubjectsByUser(int User_id);

    List<Integer> getSubjectIdByUser(int User_id);

    boolean setMark(int Exams_id, int Mark);
}
