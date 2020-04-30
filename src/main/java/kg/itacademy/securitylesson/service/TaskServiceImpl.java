package kg.itacademy.securitylesson.service;

import kg.itacademy.securitylesson.entity.Task;
import kg.itacademy.securitylesson.entity.User;
import kg.itacademy.securitylesson.model.TaskModel;
import kg.itacademy.securitylesson.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task create(TaskModel taskModel, String userLogin) {
        User user = userService.getByLogin(userLogin);
        if(user == null) {
            return null;
        }
        Task task = new Task();
        task.setUser(user);
        task.setTitle(taskModel.getTitle());
        task.setText(taskModel.getText());
        task.setIsDone(taskModel.getIsDone());
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task deleteById(Long id) {
        Task task = getById(id);
        if (task != null) {
            taskRepository.deleteById(id);
        }
        return task;
    }

    @Override
    public List<Task> getAllByUserLogin(String login) {
        return taskRepository.findAllByUser_Login(login);
    }

    @Override
    public List<Task> searchByTitle(String title) {
        return taskRepository.findAllByTitleContainingIgnoringCase(title);
    }

    @Override
    public List<Task> searchByText(String text) {
        return taskRepository.findAllByTextContainingIgnoringCase(text);
    }
}
