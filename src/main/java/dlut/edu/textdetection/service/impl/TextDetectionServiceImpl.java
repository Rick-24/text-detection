package dlut.edu.textdetection.service.impl;

import dlut.edu.textdetection.service.TextDetectionService;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/19 21:06
 */
@Service
public class TextDetectionServiceImpl implements TextDetectionService {
    @Override
    public void process(String text) {
        //todo
        PythonInterpreter interpreter = new PythonInterpreter();

        String fileName = Optional.ofNullable(this.getClass().getClassLoader().getResource("python/test.py"))
                .map(URL::getPath).get();

        interpreter.execfile(fileName);

        PyFunction pyFunction = interpreter.get("process", PyFunction.class);
        PyObject pyobj = pyFunction.__call__(new PyString(text));
    }

}
