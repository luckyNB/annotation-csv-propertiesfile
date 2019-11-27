package com.bridgelabz.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationsExamples {
    @Deprecated
    @MethodInfo(author = "Laxman", date = "27 Nov 2019", revision = 1, commets = "deprecated method")
    public static void oldMethos() {
        System.out.println("old method dont use it");
    }

    public static void main(String[] args) {

        try {
            for (Method method : AnnotationsExamples.class.getMethods()) {
                //checks if MethodInfo annotation is present for the method
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation is method" + method + ":" + anno);
                        }
                        MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1) {
                            System.out.println("Method with revision No 1=" + method);
                        }
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    @MethodInfo(author = "Laxman", date = "27 Nov 2019", revision = 1, commets = "Main method")
    public String toString() {
        return "Overriden toString method";
    }
}
