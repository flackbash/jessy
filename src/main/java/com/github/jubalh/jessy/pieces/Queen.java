package com.github.jubalh.jessy.pieces;

import com.github.jubalh.jessy.Board;
import com.github.jubalh.jessy.Color;
import com.github.jubalh.jessy.Coord;
import com.github.jubalh.jessy.NotAField;

public final class Queen extends Figure {

	public Queen() {
		super();
	}

	public Queen(Color color) {
		super(color);
	}

	protected char getBasicUnicode() {
		return '\u2655';
	}

	public boolean canMove(final Board board, final Coord current, final Coord cnew) {
		Coord coordCurrent = new Coord(current.getX(), current.getY());
		Coord coordNew = new Coord(cnew.getX(), cnew.getY());

        try {
			// up
			if (coordNew.getX() == coordCurrent.getX() && coordNew.getY() > coordCurrent.getY()) {
				while(coordNew.getY() > coordCurrent.getY()) {
					coordCurrent.increaseY(1);
					if (!isAllowedMove(board, coordCurrent, coordNew)) {
						return false;
					}
				}
			}
			// up-right diagonal
			else if (coordNew.getX() > coordCurrent.getX() && coordNew.getY() > coordCurrent.getY()) {
				while (coordNew.getX() > coordCurrent.getX() && coordNew.getY() > coordCurrent.getY()) {
					coordCurrent.increase(1);
					if (!isAllowedMove(board, coordCurrent, coordNew)) {
						return false;
					}
				}
			}
			// right
			else if (coordNew.getX() > coordCurrent.getX() && coordNew.getY() == coordCurrent.getY()) {
				while(coordNew.getX() > coordCurrent.getX()) {
					coordCurrent.increaseX(1);
					if (!isAllowedMove(board, coordCurrent, coordNew)) {
						return false;
					}
				}
			}
			// down-right diagonal
			else if (coordNew.getX() > coordCurrent.getX() && coordNew.getY() < coordCurrent.getY()) {
				while (coordNew.getX() > coordCurrent.getX() && coordNew.getY() < coordCurrent.getY()) {
					coordCurrent.decreaseY(1);
					coordCurrent.increaseX(1);
					if (!isAllowedMove(board, coordCurrent, coordNew)) {
						return false;
					}
				}
			}
			// down
			else if (coordNew.getX() == coordCurrent.getX() && coordNew.getY() < coordCurrent.getY()) {
				while(coordNew.getY() < coordCurrent.getY()) {
					coordCurrent.decreaseY(1);
					if (!isAllowedMove(board, coordCurrent, coordNew)) {
						return false;
					}
				}
			}
			// down-left diagonal
			else if (coordNew.getX() < coordCurrent.getX() && coordNew.getY() < coordCurrent.getY()) {
				while (coordNew.getX() < coordCurrent.getX() && coordNew.getY() < coordCurrent.getY()) {
					coordCurrent.decreaseY(1);
					coordCurrent.decreaseX(1);
					if (!isAllowedMove(board, coordCurrent, coordNew)) {
						return false;
					}
				}
			}
			// left
			else if (coordNew.getX() < coordCurrent.getX() && coordNew.getY() == coordCurrent.getY()) {
				while(coordNew.getX() < coordCurrent.getX()) {
					coordCurrent.decreaseX(1);
					if (!isAllowedMove(board, coordCurrent, coordNew)) {
						return false;
					}
				}
			}
			// up-left diagonal
			else if (coordNew.getX() < coordCurrent.getX() && coordNew.getY() > coordCurrent.getY()) {
				while (coordNew.getX() < coordCurrent.getX() && coordNew.getY() > coordCurrent.getY()) {
					coordCurrent.increaseY(1);
					coordCurrent.decreaseX(1);
					if (!isAllowedMove(board, coordCurrent, coordNew)) {
						return false;
					}
				}
			}
			if (coordNew.getX() == coordCurrent.getX() && coordNew.getY() == coordCurrent.getY()) {
				return true;
			}
		} catch (NotAField ex) {
			// TODO
		}
		return false;
	}
}
