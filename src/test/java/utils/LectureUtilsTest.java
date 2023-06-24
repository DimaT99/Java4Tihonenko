package utils;

import entity.Lecture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import repository.LectureRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class LectureUtilsTest {

    private LectureUtils target;

    @Mock
    private LectureRepo lectureRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.target = new LectureUtils(lectureRepo);
    }

    @Test
    void checkLecturePresence_should_return_true() throws Exception {
        given(lectureRepo.getLectureByLectureName("Lecture")).willReturn(
                new Lecture("Lecture"));

        boolean lectureExist = target.checkLecturePresence(new Lecture("Lecture"));
        assertTrue(lectureExist);

        verify(lectureRepo).getLectureByLectureName("Lecture");
    }

    @Test
    void checkLecturePresence_should_return_Null() throws Exception {
        given(lectureRepo.getLectureByLectureName("Lecture")).willReturn(null);

        boolean userExist = target.checkLecturePresence(new Lecture("Lecture"));
        assertFalse(userExist);
    }

    @Test
    void checkLecturePresence_should_throw_Exception() throws Exception {
        given(lectureRepo.getLectureByLectureName(anyString())).willThrow(Exception.class);

        assertThrows(Exception.class, () -> {
            target.checkLecturePresence(new Lecture("Lecture"));
        });
    }

    @Test
    void testCaptor() throws Exception {
        given(lectureRepo.getLectureByLectureName("Lecture")).willReturn(
                new Lecture("Lecture"));

        boolean lecture = target.checkLecturePresence(new Lecture("Lecture"));

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(lectureRepo).getLectureByLectureName(captor.capture());

        String argument = captor.getValue();

        assertEquals(argument, "Lecture");
    }

    @Test
    void whenAddCalledAnswered() {
        List<String> myList = mock(List.class);
        doAnswer(invocation -> {
            Object arg0 = invocation.getArgument(0);
            Object arg1 = invocation.getArgument(1);

            assertEquals(3, arg0);
            assertEquals("answer me", arg1);
            return null;
        }).when(myList).add(any(Integer.class), any(String.class));
        myList.add(3, "answer me");
    }

    @Test
    void his() {
        Lecture lecture = Mockito.mock(Lecture.class);
        when(lecture.getName()).thenReturn("Lecture");
        assertEquals(lecture.getName(), "Lecture");
        doReturn("true").when(lecture).getName();
    }
}