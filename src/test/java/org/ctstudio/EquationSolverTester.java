package org.ctstudio;

import org.junit.Assert;
import org.junit.Test;

public class EquationSolverTester {
  @Test
  public void testNoResult() {
    EquationsSolver solver1 = new EquationsSolver(0, 1, 3, 0, 2, 6);
    Assert.assertNull(solver1.getX());
    Assert.assertNull(solver1.getY());
    EquationsSolver solver2 = new EquationsSolver(2, 0, 4, 3, 0, 3);
    Assert.assertNull(solver2.getX());
    Assert.assertNull(solver2.getY());
  }

  @Test
  public void testXIsZero() {
    EquationsSolver solver = new EquationsSolver(0.0, 1.0, 2.0, 3.0, 2.0, 4.0);
    Assert.assertEquals(.0, solver.getX(), 0.000001);
    Assert.assertEquals(-2.0, solver.getY(), 0.000001);
  }

  @Test
  public void testNormalResult() {
    EquationsSolver solver = new EquationsSolver(1.0, 1.0, -2.0, 3.0, 1.0, -4.0);
    Assert.assertEquals(1.0, solver.getX(), 0.000001);
    Assert.assertEquals(1.0, solver.getY(), 0.000001);
  }

  @Test
  public void testDoubleResult() {
    EquationsSolver solver = new EquationsSolver(1.0, 1.0, 6.0, 3.0, 1.0, 7.0);
    Assert.assertEquals(-.5, solver.getX(), 0.000001);
    Assert.assertEquals(-5.5, solver.getY(), 0.000001);
  }
}
