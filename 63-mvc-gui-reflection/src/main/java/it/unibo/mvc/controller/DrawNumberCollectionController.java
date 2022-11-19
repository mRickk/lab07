package it.unibo.mvc.controller;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import it.unibo.mvc.api.DrawNumber;

public final class DrawNumberCollectionController implements DrawNumberController{

    private Set<DrawNumberView> viewSet;
    private final DrawNumber model;

    public DrawNumberCollectionController(final DrawNumber model) {
        this.model = model;
        this.viewSet = new HashSet<>();
    }

    @Override
    public void newAttempt(int n) {
        if (this.viewSet.isEmpty()) {
            throw new IllegalStateException("viewList is null");
        }
        DrawResult result = model.attempt(n);
        for (DrawNumberView view : this.viewSet) {
            view.result(result);
        }
    }

    @Override
    public void resetGame() {
        this.model.reset();
    }

    @Override
    public void quit() {
        System.exit(0);
    }

    @Override
    public void addView(DrawNumberView newView) {
        Objects.requireNonNull(newView, "View must not be null");
        Objects.requireNonNull(this.viewSet, "Error, viewList = null");
        this.viewSet.add(newView);
        newView.setController(this);
        newView.start();
    }
    
}
