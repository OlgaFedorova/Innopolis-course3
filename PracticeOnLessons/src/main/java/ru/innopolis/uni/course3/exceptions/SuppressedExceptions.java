package ru.innopolis.uni.course3.exceptions;

/**
 * Created by Olga on 08.12.2016.
 */
public class SuppressedExceptions {

    public static void main(String[] args) throws Exception {
        try {
            callTryFinallyBlock();
        } catch (Exception e) {
            e.printStackTrace();
            for(Throwable t: e.getSuppressed())
            {
                t.printStackTrace();
            }
        }
    }

    private static void callTryFinallyBlock() throws Exception {
        Throwable t = null;
        try
        {
            throw new TryException();
        }
        catch (Exception e) {
            t = e;
        }
        finally
        {
            FinallyException fEx = new FinallyException();
            if(t != null)fEx.addSuppressed(t);
            throw fEx;
        }
    }

    static class TryException extends Exception {
    }

    static class FinallyException extends Exception {
    }
}