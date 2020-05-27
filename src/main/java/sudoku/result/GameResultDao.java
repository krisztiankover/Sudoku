package sudoku.result;

import util.jpa.GenericJpaDao;
import java.util.List;

public class GameResultDao extends GenericJpaDao<GameResult> {

    public GameResultDao() { super(GameResult.class); }

    public List<GameResult> findBest(int n) {
        return entityManager.createQuery("SELECT r FROM GameResult r ORDER BY r.duration ASC, r.created DESC", GameResult.class)
                .setMaxResults(n)
                .getResultList();
    }
}
