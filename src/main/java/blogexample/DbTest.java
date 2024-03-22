//package blogexample;
//
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.util.List;
//import javax.management.Query;
//
//@SpringBootTest
//@ActiveProfiles("dev")
//public class DbTest {
//
//    @PersistenceContext
//    EntityManager em;
//
//    @Autowired
//    CardRepository cardRepository;
//
//    @Autowired
//    CardJpaRepository cardJpaRepository;
//
//    @Autowired
//    AssignJpaRepository assignJpaRepository;
//
//    @Autowired
//    CardSearchImpl cardSearch;
//
//    @Test
//    @Transactional
//    @Rollback(value = false)
////    @Disabled
//    void insertDummyData() {
//        long incrementId = 1L;
////        for (int i = 0; i < 100000; i++) {
////            if (i % 100 == 0 ) incrementId++;
////            CardEntity entity = CardEntity.builder()
////                .title("title" + i)
////                .description("description" + i)
////                .cardColor("0x0000")
////                .deadline(LocalDateTime.now())
////                .boardId(incrementId)
////                .taskStateId(1L)
////                .creatorId(1L)
////                .build();
////            em.persist(entity);
////        }
//        incrementId = 1L;
//        for (int i = 0; i < 1000; i++) {
//            AssignEntity assign = AssignEntity.builder()
//                .userId(incrementId)
//                .cardId(1L)
//                .build();
//            incrementId++;
//            em.persist(assign);
//        }
////        BoardEntity board = BoardEntity.builder()
////            .title("title")
////            .description("description")
////            .color("0x0000")
////            .creatorId(1L)
////            .build();
////        ParticipationEntity participation = ParticipationEntity.builder()
////            .participatorId(1L)
////            .boardId(1L)
////            .build();
////        em.persist(board);
////        em.persist(participation);
//    }
//
//    @DisplayName("조회 속도 검사")
//    @Test
//    void count_search_time() {
//        // 현재 시간 기록
//        LocalDateTime before = LocalDateTime.now();
//
//        // 조회할 쿼리 실행
//        Query query = em.createQuery("select c from CardEntity c where c.boardId = 9999");
//        List<CardEntity> resultList = query.getResultList();
//
//        // 쿼리 실행 후 현재 시간 기록
//        LocalDateTime after = LocalDateTime.now();
//
//        // 쿼리 실행 시간 계산
//        Duration duration = Duration.between(before, after);
//        long seconds = duration.getSeconds();
//        long milliseconds = duration.toMillis();
//
//        // 결과 출력
//        System.out.println("카드를 조회하는데 걸린 시간: " + seconds + "초 " + milliseconds + "밀리초");
//    }
//
//    @DisplayName("삭제 속도 검사")
//    @Transactional
//    @Rollback(value = false)
//    @Test
//    void count_delete_time() {
//        // 현재 시간 기록
//        LocalDateTime before = LocalDateTime.now();
//
//        // 조회할 쿼리 실행
//        assignJpaRepository.deleteAllByCardId(1L);
////        Query query = em.createQuery("delete from AssignEntity a where cardId = 1");
////        query.executeUpdate();
//
//        // 쿼리 실행 후 현재 시간 기록
//        LocalDateTime after = LocalDateTime.now();
//
//        // 쿼리 실행 시간 계산
//        Duration duration = Duration.between(before, after);
//        long seconds = duration.getSeconds();
//        long milliseconds = duration.toMillis();
//
//        // 결과 출력
//        System.out.println("모든 assign을 삭제하는데 걸린 시간: " + seconds + "초 " + milliseconds + "밀리초");
//    }
//}
