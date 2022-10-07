/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.FeedbackDTO;
import java.sql.SQLException;

/**
 *
 * @author haph1
 */
public interface FeedbackDAO {
    //hapham: function add feedback comment
    public void addFeedback(String feedback, int user_id, String create_date, int product_id)throws SQLException;
}
