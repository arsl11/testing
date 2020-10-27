// Generated by Selenium IDE
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class TestFic extends TestBase{

  @Test
  public void testCollection() {
    OpenHomePage();
    AccountData user = new AccountData("ars11", "Arif2012");
    Login(user);
    OpenCollections();
    CollectionData collectionData = new CollectionData("мой", "мой личный сборник");
    CreateNewCollection(collectionData);
  }

  @Test
  public void testComment() {
    OpenHomePage();
    AccountData user = new AccountData("ars11", "Arif2012");
    Login(user);
    OpenBlog();
    CommentData commentData = new CommentData("не знал");
    CreateComment(commentData);
  }

}
