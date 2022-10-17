/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.FeedbackDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author haph1
 */
public interface FeedbackDAO {
    //hapham: function add feedback comment
    public boolean addFeedback(String feedback, int user_id, String create_date, int product_id)throws SQLException;
    //hapham: function view all feedback comment
    public List<FeedbackDTO> viewAllfeedback();
    //paging feedback
    public List<FeedbackDTO> pagingFeedback(int index);
    //dem so luong feedback
    public int getTotalFeedback();
}
